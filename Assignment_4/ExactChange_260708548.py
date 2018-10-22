def main():
    num_test_cases = int(input())
    for i in range(num_test_cases):
        item_price = int(input())
        num_bills_coins = int(input())
        bills_coins = []
        for j in range(num_bills_coins):
            bills_coins.append(int(input()))

        amount_to_pay, num_bills_pay = evaluate_soln(20001, bills_coins, item_price)
        print(int(amount_to_pay), int(num_bills_pay))


def evaluate_soln(capacity, bills_coins, item_price):
    num_bills = len(bills_coins)
    dp_values = [[float("inf") for s in range(capacity+1)] for t in range(num_bills+1)]
    dp_values[0][0] = 0

    for i in range(1, num_bills+1):
        idx = i - 1
        for j in range(capacity+1):
            if dp_values[i-1][j] == float("inf"):
                continue

            dp_values[i][j] = min(dp_values[i][j], dp_values[i-1][j])
            total_money = j + bills_coins[idx]
            if total_money <= capacity:
                val = dp_values[i-1][j] + 1
                dp_values[i][total_money] = min(val, dp_values[i][total_money])

    p = item_price
    while 1:
        if dp_values[num_bills][p] != float("inf"):
            return [p, dp_values[num_bills][p]]
        p += 1

main()
