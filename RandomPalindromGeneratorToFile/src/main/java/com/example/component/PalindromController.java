package com.example.component;

import org.springframework.stereotype.Component;

@Component
public class PalindromController {

	public boolean isPalindrome(String str)
	{
		if(str.equals(getReverse(str)))
			return true;
					
		return false;
	}
	
	private static String getReverse(String string)
	{
		if(string.length() > 1)
		{
			char [] str = string.toCharArray();
			char ch;
			int end_index = str.length - 1;
		
			for(int i = 0; i < str.length / 2; i++)
			{
				ch = str[0];
				str[0] = str[end_index];
				str[end_index - i] = ch;
				
			}
			
			return new String(str);
			
		}
		return string;

	}
	
}
