package lesson06;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ConsoleGalaga {
    static final int WIDTH = 40;
    static final int HEIGHT = 20;
    static char[][] screen = new char[HEIGHT][WIDTH];
    static volatile int keyPressed = -1;
    static volatile boolean running = false;
    static int score = 0;
    static int lives = 3;
    static int stage = 1;
    static int playerLevel = 1;
    static String playerName = "Player";

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your pilot name: ");
        playerName = scanner.nextLine();

        showIntroArt();
        System.out.println("Press [SPACE] to start...");
        waitForSpacebar();

        hideCursor();
        clearScreen();

        Player player = new Player(WIDTH / 2, HEIGHT - 2, 'A');
        ArrayList<Enemy> enemies = new ArrayList<>();
        ArrayList<Bullet> bullets = new ArrayList<>();
        ArrayList<Bullet> enemyBullets = new ArrayList<>();

        initEnemiesForStage(enemies, stage);
        startInputThread();
        running = true;

        while (running) {
            handleInput(player, bullets);
            updatePlayerLevel();

            player.update();
            enemies.forEach(Enemy::update);
            bullets.forEach(Bullet::update);
            enemyBullets.forEach(Bullet::update);

            bullets.removeIf(b -> b.y < 0);
            enemyBullets.removeIf(b -> b.y >= HEIGHT);

            checkCollisions(player, enemies, bullets, enemyBullets);
            spawnEnemyBullets(enemies, enemyBullets);

            render(player, enemies, bullets, enemyBullets);

            if (enemies.isEmpty()) {
                stage++;
                if (stage > 5) break;
                initEnemiesForStage(enemies, stage);
                showStageIntro(stage);
            }

            if (lives <= 0) break;

            Thread.sleep(100);
        }

        System.out.print("\033[H");
        System.out.println(enemies.isEmpty() ? "*** YOU WIN, " + playerName + "! ***" : "*** GAME OVER ***");
        showCursor();
        System.exit(0);
    }

    static void showIntroArt() {
        System.out.println("\n   🚀 Console Galaga: ASCII Invasion 🚀\n");
        System.out.println("       .--.      .--.     ");
        System.out.println("      : (\\\\ \".----.\" \\\\) :   ");
        System.out.println("       '.    '----'    .' ");
        System.out.println("        /\\          /\\  ");
        System.out.println("       (  \\.__.__./  )  ");
        System.out.println("        '._  \\__/  _.'  ");
        System.out.println("           '--..--'     \n");
    }

    static void waitForSpacebar() {
        try {
            while (true) {
                if (System.in.available() > 0 && System.in.read() == ' ') break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void startInputThread() {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    if (System.in.available() > 0) {
                        keyPressed = System.in.read();
                    }
                    Thread.sleep(10);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    static void handleInput(Player player, ArrayList<Bullet> bullets) {
        int key = keyPressed;
        keyPressed = -1;
        switch (key) {
            case 27 -> running = false;
            case 'a', 'A' -> player.move(-1, 0);
            case 'd', 'D' -> player.move(1, 0);
            case ' ', 'w' -> bullets.add(new Bullet(player.x, player.y - 1, '|', 0, -1));
        }
    }

    static void updatePlayerLevel() {
        if (score >= 15) playerLevel = 5;
        else if (score >= 10) playerLevel = 4;
        else if (score >= 6) playerLevel = 3;
        else if (score >= 3) playerLevel = 2;
        else playerLevel = 1;
    }

    static void initEnemiesForStage(ArrayList<Enemy> enemies, int stage) {
        enemies.clear();
        int count = 6 + stage * 2;
        for (int i = 0; i < count; i++) {
            enemies.add(new Enemy(2 + i % 10 * 3, 2 + (i / 10), 'M'));
        }
    }

    static void showStageIntro(int stage) throws InterruptedException {
        System.out.print("\033[H");
        System.out.println("\n=== STAGE " + stage + " ===\n");
        Thread.sleep(1000);
        clearScreen();
    }

    static void checkCollisions(Player player, ArrayList<Enemy> enemies,
                                ArrayList<Bullet> bullets, ArrayList<Bullet> enemyBullets) {
        bullets.removeIf(b -> {
            for (Enemy e : enemies) {
                if (b.x == e.x && b.y == e.y) {
                    enemies.remove(e);
                    score++;
                    return true;
                }
            }
            return false;
        });

        enemyBullets.removeIf(b -> {
            if (b.x == player.x && b.y == player.y) {
                lives--;
                return true;
            }
            return false;
        });
    }

    static void spawnEnemyBullets(ArrayList<Enemy> enemies, ArrayList<Bullet> enemyBullets) {
        for (Enemy e : enemies) {
            if (Math.random() < 0.01 + (stage * 0.005)) {
                enemyBullets.add(new Bullet(e.x, e.y + 1, '!', 0, 1));
            }
        }
    }

    static void render(Player player, ArrayList<Enemy> enemies,
                       ArrayList<Bullet> bullets, ArrayList<Bullet> enemyBullets) {
        clearScreenBuffer();
        player.draw(screen);
        enemies.forEach(e -> e.draw(screen));
        bullets.forEach(b -> b.draw(screen));
        enemyBullets.forEach(b -> b.draw(screen));

        System.out.print("\033[H");
        StringBuilder sb = new StringBuilder();
        sb.append("+").append("-".repeat(WIDTH * 2)).append("+\n");
        for (char[] row : screen) {
            sb.append("|");
            for (char c : row) sb.append(colorize(c));
            sb.append("|\n");
        }
        sb.append("+").append("-".repeat(WIDTH * 2)).append("+\n");
        sb.append(String.format(" %s | Score: %-5d | Lives: %s | Lv.%d | Stage: %d\n",
                playerName,
                score,
                "♥".repeat(lives),
                playerLevel,
                stage));
        sb.append(" Controls: A/D = Move, Space = Shoot, ESC = Quit\n");
        System.out.print(sb);
        System.out.flush();
    }

    static void clearScreenBuffer() {
        for (int y = 0; y < HEIGHT; y++)
            for (int x = 0; x < WIDTH; x++)
                screen[y][x] = ' ';
    }

    static String colorize(char c) {
        return switch (c) {
            case 'A' -> "\033[32mA \033[0m";
            case 'M' -> "\033[31mM \033[0m";
            case '|' -> "\033[36m| \033[0m";
            case '!' -> "\033[33m! \033[0m";
            default -> "  ";
        };
    }

    static void clearScreen() {
        System.out.print("\033[2J\033[H");
    }

    static void hideCursor() {
        System.out.print("\033[?25l");
    }

    static void showCursor() {
        System.out.print("\033[?25h");
    }

    static abstract class Entity {
        int x, y;
        char glyph;
        Entity(int x, int y, char glyph) {
            this.x = x;
            this.y = y;
            this.glyph = glyph;
        }
        void draw(char[][] buf) {
            if (y >= 0 && y < HEIGHT && x >= 0 && x < WIDTH) buf[y][x] = glyph;
        }
        abstract void update();
    }

    static class Player extends Entity {
        Player(int x, int y, char glyph) { super(x, y, glyph); }
        @Override void update() {}
        void move(int dx, int dy) {
            x = Math.max(0, Math.min(WIDTH - 1, x + dx));
            y = Math.max(0, Math.min(HEIGHT - 1, y + dy));
        }
    }

    static class Enemy extends Entity {
        private int dir = 1, stepCount = 0, frameCount = 0;
        Enemy(int x, int y, char glyph) { super(x, y, glyph); }
        @Override
        void update() {
            if (++frameCount % 3 == 0) {
                x += dir;
                stepCount++;
                if (stepCount >= 5) {
                    dir = -dir;
                    stepCount = 0;
                    y++;
                }
            }
        }
    }

    static class Bullet extends Entity {
        int dx, dy;
        Bullet(int x, int y, char glyph, int dx, int dy) {
            super(x, y, glyph);
            this.dx = dx;
            this.dy = dy;
        }
        @Override void update() {
            x += dx;
            y += dy;
        }
    }
}
