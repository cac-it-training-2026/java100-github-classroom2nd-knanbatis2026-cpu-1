/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題4 注文を受ける
 *
 * 3種類のマカロンを任意の個数購入できるようにします。
 * [問題3]までの表示を行った後で
 * 実行例を参考に処理を追記してください。
 * （ >8 は >を表示した後で入力待ち状態になり、
 *   ユーザーがキーボードから8を入力したイメージです。）
 *
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
 * をお買いあげですね。
 * 承りました。
 */

package lesson01.challenge04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Patisserie {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int citron = 30;
		int chocolat = 30;
		int pistache = 30;

		System.out.println("たいへんお待たせしました。\r\n" + //
				"【ポエール・ネルメ】\r\n" + //
				" ただいまより開店です！！");

		System.out.println("本日のおすすめ商品です。\n" +
				" \n" + //
				"シトロン      ￥250 ・・・ 残り" + citron + "個\n" +
				"ショコラ      ￥280 ・・・ 残り" + chocolat + "個\n" +
				"ピスターシュ  ￥320 ・・・ 残り" + pistache + "個");

		System.out.println("それぞれ何個ずつ買いますか？(最大30個まで)");
		System.out.println();

		System.out.print("シトロン\t＞");
		int citron_count = Integer.parseInt(br.readLine());
		System.out.print("ショコラ\t＞");
		int chocolat_count = Integer.parseInt(br.readLine());
		System.out.print("ピスターシュ\t＞");
		int pistache_count = Integer.parseInt(br.readLine());

		System.out.println();

		System.out.println("シトロン\t" + citron_count + "個");
		System.out.println("ショコラ\t" + chocolat_count + "個");
		System.out.println("ピスターシュ\t" + pistache_count + "個");

		System.out.println();
		System.out.println("をお買いあげですね。\n"
				+ "承りました。");
	}
}
