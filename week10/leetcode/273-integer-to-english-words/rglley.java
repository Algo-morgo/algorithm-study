class Solution {
    String[] belowTwenty;
    String[] tens;

    public String numberToWords(int num) {
        belowTwenty = new String[]{"", "One", "Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine", "Ten",
         "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        return num == 0 ? "Zero" : convert(num);
    }

    private String convert(int num) {
        StringBuilder result = new StringBuilder();
        
        if (num < 20) {
            result.append(belowTwenty[num]);
        } else if (num < 100) {
            result.append(tens[num / 10]);
            if (num % 10 != 0) {
                result.append(" ").append(belowTwenty[num % 10]);
            }
        } else if (num < 1000) {
            result.append(convert(num / 100)).append(" Hundred");
            if (num % 100 != 0) {
                result.append(" ").append(convert(num % 100));
            }
        } else if (num < 1000000) {
            result.append(convert(num / 1000)).append(" Thousand");
            if (num % 1000 != 0) {
                result.append(" ").append(convert(num % 1000));
            }
        } else if (num < 1000000000) {
            result.append(convert(num / 1000000)).append(" Million");
            if (num % 1000000 != 0) {
                result.append(" ").append(convert(num % 1000000));
            }
        } else {
            result.append(convert(num / 1000000000)).append(" Billion");
            if (num % 1000000000 != 0) {
                result.append(" ").append(convert(num % 1000000000));
            }
        }
        
        return result.toString();
    }
}
