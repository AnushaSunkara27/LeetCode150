class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         // Convert list to set for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // dp[i] = true if s[0...i-1] can be segmented
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string is always "breakable"

        // Check every prefix of the string
        for (int i = 1; i <= s.length(); i++) {
            // Check every possible partition point j < i
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] is breakable and s[j...i-1] is a word
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }

        return dp[s.length()];

    }
}