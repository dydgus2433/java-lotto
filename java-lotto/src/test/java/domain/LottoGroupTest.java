package domain;

import domain.wrapper.EarningRate;
import domain.wrapper.Money;
import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    LottoGroup lottoGroup;
    Lotto lastLotto;


    @Before
    public void setUp() {
        lastLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGroup = new LottoGroup(Arrays.asList(lastLotto, lastLotto, lastLotto));
    }

    @Test
    public void 로또가격만큼산개수() {
        LottoGroup buyLottoGroup = new LottoGroup(14);
        assertThat(buyLottoGroup.getSize()).isEqualTo(14);
    }

    @Test
    public void 총수입률() {
        int price = 14000;
        int totalRewards = 5000;
        EarningRate earningRate = new EarningRate(new Money(price), new Money(totalRewards));
        assertThat(earningRate.getEarningRate()).isEqualTo(((double) 5000 / (double) 14000));
    }

    @Test
    public void 당첨개수테스트() {
        List<Lotto> lottoList = Arrays.asList(lastLotto, lastLotto, lastLotto);
        Lotto lastLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] combineNumbers = new int[7];
        for (Lotto lotto : lottoList) {
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        assertThat(combineNumbers[6]).isEqualTo(3);
    }

    @Test
    public void 미당첨개수테스트() {
        List<Lotto> lottoList = Arrays.asList(lastLotto, lastLotto, lastLotto);
        List<Integer> diffNum = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto diff = new Lotto(diffNum);
        int[] combineNumbers = new int[7];
        for (Lotto lotto : lottoList) {
            combineNumbers[lotto.getCombineCount(diff)]++;
        }
        assertThat(combineNumbers[0]).isEqualTo(3);
    }

}
