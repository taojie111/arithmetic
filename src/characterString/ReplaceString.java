package characterString; // 包路径不可修改!!!

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * 题目：给定一个字符串（只包含小写英文字母），按顺序执行以下两条规则，输出计算后的字符串。
 * <p>
 * 规则 1：对于连续顺序4位及以上的字母，中间使用“~”替换。
 * 例如：ahhhhhhbcdefko, 替换后为ahhhhhhb~fko。
 * <p>
 * 规则2：对于连续重复出现3个及以上的字母，以该字母+重复的个数替换。
 * 例如：ahhhhhhbcdefko，替换后为ah6bcdefko。
 * <p>
 * 总体示例：
 * 输入字符串为：ahhhhhhbcdefko     结果为：ah6b~fko
 * 输入字符串为：ahhhhhhbcdefko     结果为：ah6b~fko
 * 输入字符串为：ammmmmnopqko       结果为：am5~qko
 * 输入字符串为：abcdefffffadfasdfa 结果为：a~f5adfasdfa
 * 输入字符串为：mnopqqqrstabs      结果为：m~q3~tabs
 * 输入字符串为：xyzabcd 			  结果为：xyza~d
 * <p>
 * 提示：
 * 1. 规则按规则1，规则2顺序执行。先执行1，后执行2。
 * 2. 请注意边界值的考虑，注意连续出现条件匹配的情况。
 * 3. 请注意字符串拼接的性能消耗。
 * 4. 请先花一定时间理清思路在再编写代码。
 * 5. 可以试着把上面总体实例中的例子跑正确后再提交。
 * @author taojie
 */
public class ReplaceString { //类名不可修改!!!
	/**
	 * 程序逻辑请在该方法中完成
	 * <p>
	 * 注意：
	 * 1. 方法名、参数个数及类型不可更改，只可修改函数体!!!
	 * 2. 提交文件时，保证包路径package com.yinhai.onehour
	 *
	 * @param inData 参数 验证程序通过该参数传入字符串
	 * @return 返回值 验证程序通过该返回值验证程序正确性
	 */
	public String methodTest(String inData) {

		String result = inData;
		char[] chars = inData.toCharArray();
		int length = inData.length();
		int start = 0;
		int end = 1;

		// 连续替换
		while (end < length) {
			if (chars[end] - chars[end - 1] == 1) {
				if (end == length - 1) {
					if (end - start + 1 >= 4) {
						result = result.replaceFirst(getBuilder(chars, start + 1, end).toString(), "~");
					}
				}
				end++;
			} else {
				if (end - start >= 4) {
					result = result.replaceFirst(getBuilder(chars, start + 1, end - 1).toString(), "~");
				}
				start = end;
				end++;
			}
		}

		// 重复替换
		start = 0;
		end = 1;
		length = result.length();
		chars = result.toCharArray();
		while (end < length) {
			if (chars[end] - chars[end - 1] == 0) {
				if (end == length - 1) {
					if (end - start + 1 >= 3) {
						result = result.replaceFirst(getBuilder(chars, start, end + 1).toString(), chars[start] + String.valueOf(end - start + 1));
					}
				}
				end++;
			} else {
				if (end - start >= 3) {
					result = result.replaceFirst(getBuilder(chars, start, end).toString(), chars[start] + String.valueOf(end - start));
				}
				start = end;
				end++;
			}
		}
		return result;
	}

	public static StringBuilder getBuilder(char[] chars, int start, int end) {
		StringBuilder builder = new StringBuilder();
		for (int i = start; i < end; i++) {
			builder.append(chars[i]);
		}
		return builder;
	}

	/**
	 * 可修改，验证自己的答案
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// 用于自己校验结果
		ReplaceString template = new ReplaceString();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i <= 10000; i++) {
			builder.append("abcdefffffadfasdfa");
		}
		long startTime = System.currentTimeMillis();
		String result = template.methodTest(builder.toString());
		System.out.println(result);
		long endTime = System.currentTimeMillis();
		System.out.println("耗时(毫秒)：" + (endTime - startTime));
	}
}
