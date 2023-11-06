package domain;

import lotto.Lotto;

import java.util.List;

public class LottoWinChecker {
    private final List<Integer> winningNumbers;
    private List<Integer> userNumbers;


    boolean correctBonus = false;


    public LottoWinChecker(Lotto lotto, List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.userNumbers = lotto.getNumbers();

        int correctNumbers = getCorrectNumbersCount();
        bonusChecker();

        if (correctNumbers == 6) {
            lotto.setRank(Lotto.LottoRank.FIRST);
        }
        if (correctNumbers == 5 && correctBonus) {
            lotto.setRank(Lotto.LottoRank.SECOND);
        }
        if (correctNumbers == 5 && !correctBonus) {
            lotto.setRank(Lotto.LottoRank.THIRD);
        }
        if (correctNumbers == 4) {
            lotto.setRank(Lotto.LottoRank.FOURTH);
        }
        if (correctNumbers == 3) {
            lotto.setRank(Lotto.LottoRank.FIFTH);
        }
    }

    int getCorrectNumbersCount() {
        int correctNumbersCount = 0;

        for (int i = 0; i < 6; i++) {
            int winningNumber = this.winningNumbers.get(i);
            if (this.userNumbers.contains(winningNumber)) {
                correctNumbersCount++;
            }
        }

        return correctNumbersCount;
    }

    void bonusChecker() {
        int bonusNumber = this.winningNumbers.get(6);

        if (this.userNumbers.contains(bonusNumber)) {
            correctBonus = true;
        }
    }
}
