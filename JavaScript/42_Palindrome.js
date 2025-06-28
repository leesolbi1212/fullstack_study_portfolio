function isPalindrome(str, left = 0, right = null) {
  if (right === null) {
    right = str.length - 1; // right 초기화
  }
  if (left >= right) return true; // 모든 문자 비교 완료
  if (str[left] !== str[right]) return false; // 불일치 시 false
  return isPalindrome(str, left + 1, right - 1); // 재귀 호출
}

console.log(isPalindrome("역삼역")); // true
console.log(isPalindrome("hello")); // false
console.log(isPalindrome("level")); // true
console.log(isPalindrome("이솔비")); // false
