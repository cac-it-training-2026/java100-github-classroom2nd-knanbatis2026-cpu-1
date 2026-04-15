/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題1 開店メッセージの表示
 *
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 * たいへんお待たせしました。
 *【ポエール・ネルメ】
 * ただいまより開店です！！
 *test
 */

package lesson01.challenge01;

public class Patisserie {
	public static void main(String[] args) {
		System.out.println("たいへんお待たせしました。\r\n" + //
				"【ポエール・ネルメ】\r\n" + //
				" ただいまより開店です！！");

		System.out.println("本日のおすすめ商品です。\n" +
				" \n" + //
				"シトロン      \\250\n" +
				"ショコラ      \\280\n" +
				"ピスターシュ  \\320");
	}
}