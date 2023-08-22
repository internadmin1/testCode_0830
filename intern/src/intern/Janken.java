package intern;

import java.util.Random;
import java.util.Scanner;

public class Janken {

	public static void main(String[] args) {

		// ユーザの手をキーボードから入力してもらう
		int user = getUser();

		// コンピュータの手を乱数で作成する
		int pc = getPc();

		// 勝敗の判定を行う
		String result = judgeJanken(user,pc);

		// 結果を表示する
		showResult(user,pc,result);
	}

	public static int getUser() {
		// キーボード入力の準備
		Scanner stdin = new Scanner(System.in);

		// 無限ループ
		while(true) {
			// メッセージの表示
			System.out.println("あなたのじゃんけんの手を入力して下さい");
			System.out.print("(グー：0，チョキ：1、パー：2)　--> ");

			// 入力されたデータが整数かどうかのチェック
			if(stdin.hasNextInt()) {
				// 入力されたデータを整数として読み込む
				int number = stdin.nextInt();
				// 整数でも有効なのは「0，1，2」のみ
				if(number<=-1 || number >=3) {
					// 範囲外は無効なデータなのでやり直し
					System.out.println("【エラー】入力できるのは「0～2」です");
					continue;
				}else {
					// 0,1,2の場合、メソッドの結果として返す
					return number;
				}
			}else {
				// 整数以外の場合、無効なデータなのでやり直し
				System.out.println("【エラー】入力できるのは整数だけです");
				// 不要なトークンをバッファから取り除く
				stdin.next();
			}
		}
	}

	public static int getPc() {
		// 乱数の準備
		Random rand = new Random();
		// 0,1,2のどれかを求め、メソッドの結果として返す
		return rand.nextInt(3);
	}

	public static String judgeJanken(int user,int pc) {
		String result=""; // 判定結果を保存する

		if((user==0 && pc==1) || (user==1 && pc==2) || (user==2 && pc==0)) {
			result="勝ち";
		}else if( (user==0 && pc==2) || (user==1 && pc==0) || (user==2 && pc==1)) {
			result="まけ";
		}else {
			result="あいこ";
		}

		// 勝敗結果を返す
		return result;
	}

	public static void showResult(int user,int pc,String result) {
		// じゃんけんの手を配列で定義
		String[] janken= {"グー","チョキ","パー"};
		// 結果の表示
		System.out.println("あなたの手:"+janken[user]+",コンピュータの手:"+janken[pc]);
		System.out.println("結果："+result);

	}
}