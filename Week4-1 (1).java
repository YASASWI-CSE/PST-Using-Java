class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
		char[] arr=s.toCharArray();
		int half=arr.length/2;
		int counta=0,countb=0;
		for (int i = 0; i < half; i++) {
	        if ("aeiou".indexOf(arr[i]) != -1) counta++;
	    }

	    for (int i = half; i < arr.length; i++) {
	        if ("aeiou".indexOf(arr[i]) != -1) countb++;
	    }
		return counta==countb;
    }
}
