/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題9 新商品の開発
 *
 * 翌日から新商品を発売することにしました。
 * 新商品の名前は「三色マカロン」です。
 * シトロン、ショコラ、ピスターシュの３つの味が
 * 1個のマカロンに集約されているのが特徴で、
 * その配合率は前日の売上比で決まり、
 * 価格はマカロン１個あたりの平均売上価格に準じて
 * 自動的に決定されます。（ただし、1の位は切り捨て）
 *
 * 以下の実行例を参考に処理を追記、改変してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
 *
 * 閉店時間となりました。
 * またのお越しをお待ちしております。
 *
 * 売上の割合
 * 売上合計      \2470
 *
 * 内訳
 * シトロン      \1250・・・ 50%
 * ショコラ      \420・・・ 17%
 * ピスターシュ  \800・・・ 32%
 *
 * 明日の三色マカロンの配合率が決まりました！
 *
 * シトロンの味    ・・・ 50%
 * ショコラの味    ・・・ 17%
 * ピスターシュの味・・・ 32%
 *
 * が楽しめます！
 *
 * 値段は\270です。
 *
 */

package lesson01.challenge09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Patisserie {
	public static void main(String[] args) throws IOException {
		System.out.println("たいへんお待たせしました。\r\n" + //
				"【ポエール・ネルメ】\r\n" + //
				" ただいまより開店です！！\n");
		// 在庫数
		int citron = 30;
		int chocolat = 30;
		int pistache = 30;

		// 売値
		int citron_price = 250;
		int chocolat_price = 280;
		int pistache_price = 320;

		System.out.println("本日のおすすめ商品です。\n" +
				" \n" + //
				"シトロン      ￥250 ・・・ 残り" + citron + "個\n" +
				"ショコラ      ￥280 ・・・ 残り" + chocolat + "個\n" +
				"ピスターシュ  ￥320 ・・・ 残り" + pistache + "個\n");

		System.out.println("それぞれ何個ずつ買いますか？(最大30個まで)\n");

		System.out.print("シトロン\t>");
		double citron_count = getDouble();
		System.out.print("ショコラ\t>");
		double chocolat_count = getDouble();
		System.out.print("ピスターシュ\t>");
		double pistache_count = getDouble();

		System.out.println("\nシトロン\t" + citron_count + "個");
		System.out.println("ショコラ\t" + chocolat_count + "個");
		System.out.println("ピスターシュ\t" + pistache_count + "個");

		// 購入個数
		double count = citron_count + chocolat_count + pistache_count;

		// それぞれの購入金額
		double citron_sales = citron_count * citron_price;
		double chocolat_sales = chocolat_count * chocolat_price;
		double pistache_sales = pistache_count * pistache_price;

		// 合計の購入金額
		int sum_sales = (int) (citron_sales + chocolat_sales + pistache_sales);

		System.out.println("\n合計個数\t" + count + "個");
		System.out.println("合計金額\t" + sum_sales + "円\n");
		System.out.println("をお買い上げですね。\n" + "承りました。\n");

		// 個数を減らす
		citron -= citron_count;
		chocolat -= chocolat_count;
		pistache -= pistache_count;

		System.out.println("本日のおすすめ商品です。\n" +
				" \n" + //
				"シトロン      ￥250 ・・・ 残り" + citron + "個\n" +
				"ショコラ      ￥280 ・・・ 残り" + chocolat + "個\n" +
				"ピスターシュ  ￥320 ・・・ 残り" + pistache + "個\n");

		System.out.println("閉店の時間となりました。\n" +
				"またのお越しをお待ちしております。\n");

		System.out.println("売上の割合\n" +
				"売上合計\t" +
				"￥" + sum_sales + "\n");

		// 売上の割合
		int citron_ratio = (int) (citron_sales / sum_sales * 100);
		int chocolat_ratio = (int) (chocolat_sales / sum_sales * 100);
		int pistache_ratio = (int) (pistache_sales / sum_sales * 100);

		System.out.println("内訳");
		System.out.println(
				"シトロン\t" + "￥" + (int) citron_sales + "\t・・・" + citron_ratio + "%");
		System.out.println(
				"ショコラ\t" + "￥" + (int) chocolat_sales + "\t・・・" + chocolat_ratio + "%");
		System.out.println(
				"ピスターシュ\t" + "￥" + (int) pistache_sales + "\t・・・" + pistache_ratio + "%\n");

		System.out.println("明日の3色マカロンの配合率が決まりました！");

		System.out.println(
				"シトロンの味\t" + "・・・" + citron_ratio + "%");
		System.out.println("ショコラ\t" + "・・・" + chocolat_ratio + "%");
		System.out.println("ピスターシュ\t" + "・・・" + pistache_ratio + "%\n");

		System.out.println("が楽しめます。\n");

		// 明日の値段
		int mix_price = ((citron_price * citron_ratio) + (chocolat_price * chocolat_ratio)
				+ (pistache_price * pistache_ratio)) / 1000 * 10;

		System.out.println("値段は￥" + mix_price + "です");
	}

	public static double getDouble() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		double num = Double.parseDouble(str);
		return num;
	}
}