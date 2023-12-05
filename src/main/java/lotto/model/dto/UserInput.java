package lotto.model.dto;

import lotto.constant.Constant;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static class WinnerNumbersDTO {
        private final String numbers;

        public WinnerNumbersDTO(String numbers) {
            validateAllIsNumber(numbers);
            validateNotNull(numbers);
            this.numbers = numbers;
        }

        public List<Integer> toList() {
            return Arrays.stream(numbers.split(Constant.NUMBER_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        }

        private void validateAllIsNumber(String numbers) {
            String[] split = numbers.split(Constant.NUMBER_DELIMITER);
            Arrays.stream(split)
                    .forEach(UserInput::validateIsNumber);
        }
    }

    public static class BonusNumDTO {
        private final int bonusNum;

        public BonusNumDTO(String bonusNum) {
            validateNotNull(bonusNum);
            validateIsNumber(bonusNum);
            this.bonusNum = Integer.parseInt(bonusNum);
        }

        public int getBonusNum() {
            return bonusNum;
        }
    }

    public static class purchasePriceDTO {
        private final int price;

        public purchasePriceDTO(String price) {
            validateIsNumber(price);
            validateNotNull(price);
            this.price = Integer.parseInt(price);
        }

        public int getPrice() {
            return price;
        }
    }

    private static void validateNotNull(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("빈 입력");
        }
    }

    private static void validateIsNumber(String userInput) {
        boolean isNumber = userInput.chars().allMatch(Character::isDigit);
        if(!isNumber) {
            throw new IllegalArgumentException("숫자가 아님");
        }
    }
}
