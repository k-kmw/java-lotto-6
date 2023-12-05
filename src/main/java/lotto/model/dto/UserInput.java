package lotto.model.dto;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static class WinnerNumbersDTO {
        private String numbers;

        public WinnerNumbersDTO(String numbers) {
            validateNotNull(numbers);
            this.numbers = numbers;
        }

        public List<Integer> toList() {
            return Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .toList();
        }
    }

    public static class BonusNumDTO {
        private String bonusNum;

        public BonusNumDTO(String bonusNum) {
            validateNotNull(bonusNum);
            this.bonusNum = bonusNum;
        }

        public String getBonusNum() {
            return bonusNum;
        }
    }

    public static class purchasePriceDTO {
        private String price;

        public purchasePriceDTO(String price) {
            validateNotNull(price);
            this.price = price;
        }

        public String getPrice() {
            return price;
        }
    }

    private static void validateNotNull(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("빈 입력");
        }
    }
}
