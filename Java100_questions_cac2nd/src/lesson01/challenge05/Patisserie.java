/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題5 合計金額を求める
 *
 * 入力されたマカロンの個数から合計購入数、合計金額を求めます。
 * 合計購入数、合計金額を求める処理を追記した後で
 * [問題4]の表示を実行例を参考にして改変してください。
 *
 * <実行例>
 *
 * それぞれ何個ずつ買いますか？（最大30個まで）
 *
 * シトロン      >8
 * ショコラ      >2
 * ピスターシュ  >6
 *
 * シトロン     8個
 * ショコラ     2個
 * ピスターシュ 6個
 *
 * 合計個数    16個
 * 合計金額  4480円
 *
 * をお買いあげですね。
 * 承りました。
 *
 */

package lesson01.challenge05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Patisserie {
	public static void main(String[] args) throws IOException {
		System.out.println("たいへんお待たせしました。\r\n" + //
				"【ポエール・ネルメ】\r\n" + //
				" ただいまより開店です！！\n");
		int citron = 30;
		int chocolat = 30;
		int pistache = 30;

		System.out.println("本日のおすすめ商品です。\n" +
				" \n" + //
				"シトロン      ￥250 ・・・ 残り" + citron + "個\n" +
				"ショコラ      ￥280 ・・・ 残り" + chocolat + "個\n" +
				"ピスターシュ  ￥320 ・・・ 残り" + pistache + "個\n");

		System.out.println("それぞれ何個ずつ買いますか？(最大30個まで)\n");

		System.out.println("シトロン");
		int citron_count = getInt();
		System.out.println("ショコラ");
		int chocolat_count = getInt();
		System.out.println("ピスターシュ");
		int pistache_count = getInt();

		System.out.println("\nシトロン\t" + citron_count + "個");
		System.out.println("ショコラ\t" + chocolat_count + "個");
		System.out.println("ピスターシュ\t" + pistache_count + "個");

		int count = citron_count + chocolat_count + pistache_count;

		int sum_price = citron_count * 250 + chocolat_count * 280 + pistache_count * 320;
		System.out.println("\n合計個数\t" + count + "個");
		System.out.println("合計金額\t" + sum_price + "円\n");
		System.out.println("をお買い上げですね。\n" + "承りました。");

	}

	public static int getInt() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		int num = Integer.parseInt(str);
		return num;
	}
}