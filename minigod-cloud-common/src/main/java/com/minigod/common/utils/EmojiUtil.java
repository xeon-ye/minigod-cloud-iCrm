package com.minigod.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.vdurmont.emoji.EmojiParser;

/**
 * @Title: EmojiUtil.java
 * @Description: Emoji符号处理
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-1-16 下午5:58:04
 * @version v1.0
 */

public class EmojiUtil {

	protected static List<String> getAliasesCandidates(String input) {
		List<String> candidates = new ArrayList<String>();
		String regex = "(?<=:)\\+?\\w+(?=:)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		matcher = matcher.useTransparentBounds(true);
		while (matcher.find()) {
			candidates.add(matcher.group());
		}
		return candidates;
	}

	/**
	  * 带emoji字符的长度，一个汉字算1个字符
	  * @param source
	  * @return
	  */
	public static int charLength(String html) {
		if (StringUtils.isEmpty(html)) {
			return 0;
		}
		List<String> aliases = getAliasesCandidates(EmojiParser.parseToAliases(EmojiParser.parseToUnicode(html)));
		int aliase = aliases.size();
		int htmlLength = html.length();
		if (aliase > 0) {
			htmlLength = htmlLength - (aliase * 9) + aliase;
		}
		return htmlLength;
	}

	/**
	  * 带emoji字符的长度，一个汉字算2个字符
	  * @param source
	  * @return
	  */
	public static int charLength1(String html) {
		if (StringUtils.isEmpty(html)) {
			return 0;
		}
		List<String> aliases = getAliasesCandidates(EmojiParser.parseToAliases(EmojiParser.parseToUnicode(html)));
		int aliase = aliases.size();
		int htmlLength = getStrLength(html);
		if (aliase > 0) {
			htmlLength = htmlLength - (aliase * 9) + aliase;
		}
		return htmlLength;
	}

	public static int getStrLength(String s) {
		if (s == null)
			return 0;
		char[] c = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++) {
			len++;
			if (!isLetter(c[i])) {
				len++;
			}
		}
		return len;
	}

	public static boolean isLetter(char c) {
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	public static String emojiToHtml(String text) {
		return EmojiParser.parseToAliases(EmojiParser.parseToUnicode(text));
	}

	public static String htmlToEmoji(String text) {
		return EmojiParser.parseToUnicode(text);
	}

	public static void main(String[] args) {
		System.err.println(emojiToHtml("&#128521;&#128536;&#128516;&#128515;&#128541;&#128536;&#128536;&#128513;&#128527;&#128516;"));
	}
}
