/**
 * 第7章 武士のお仕事
 *
 * 問題14 複数のインターフェースを実装する
 *
 * 勘定奉行インタフェース、文化人インターフェースを実装する。
 *
 * 藩士クラスに勘定奉行インターフェースと文化人インターフェースを
 * 実装してください。
 *
 * <実行例>
 * 藩士1：
 * 藩の資産を計算するよ～。
 * 茶道を嗜むよ～。
 *
 */

package lesson07.challenge14;

//ここにIChiefTreasurerインターフェースを記述
interface IChiefTreasurer {
	public abstract void figure();
}

//ここにICelebrityインターフェースを記述
interface ICelebrity {
	public abstract void learn();
}

//ここにSamuraiクラスを記述
abstract class Samurai {
	abstract void work();
}

//ここにRetainerクラスを記述
class Retainer extends Samurai implements ICelebrity, IChiefTreasurer {
	@Override
	void work() {
		System.out.println("年貢を取り立てるよ～。");
	}

	@Override
	public void learn() {
		System.out.println("茶道を嗜むよ～。");
	}

	@Override
	public void figure() {
		System.out.println("藩の資産を計算するよ～。");
	}
}

public class CastleTown {

	public static void main(String[] args) {
		System.out.println("藩士1：");

		//ここに適切な処理を記述;
		Retainer reta = new Retainer();

		reta.figure();
		reta.learn();

	}
}
