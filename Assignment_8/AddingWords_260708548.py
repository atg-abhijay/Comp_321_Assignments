import sys

def main():
    vars_dict = {}
    # while True:
    #     line = input()
    #     if line is None:
    #         break
    for line in sys.stdin.readlines():
        tokens = line.split(' ')
        first_token = tokens[0]

        if first_token == 'def':
            vars_dict[tokens[1]] = int(tokens[2])

        elif first_token == 'calc':
            is_valid = True
            result, add_or_subtract, count = 0, 1, 1
            num_terms = len(tokens) - 2
            while count <= num_terms:
                token = tokens[count]
                if token == '+':
                    add_or_subtract = 1

                elif token == '-':
                    add_or_subtract = -1

                else:
                    if token not in vars_dict:
                        print_answer(tokens, "unknown")
                        is_valid = False
                        break

                    result += add_or_subtract*vars_dict[token]

                count += 1

            if is_valid:
                found = False
                for var_name, val in vars_dict.items():
                    if val == result:
                        print_answer(tokens, var_name)
                        found = True
                        break

                if not found:
                    print_answer(tokens, "unknown")


        else:
            vars_dict = {}


def print_answer(tokens, answer):
    print(' '.join(tokens[1:-1]), '=', answer)


main()
