# Python3
from sys import stdin

def main():
    # dictionary with key = variable name
    # and value = variable value
    vars_dict = {}
    for line in stdin.readlines():
        tokens = line.split(' ')
        first_token = tokens[0]

        # check the first token to
        # see if the command is 'def',
        # 'calc' or 'clear'
        if first_token == 'def':
            vars_dict[tokens[1]] = int(tokens[2])

        elif first_token == 'calc':
            is_valid = True
            result, add_or_subtract, count = 0, 1, 1
            # counts the number of terms/tokens
            # except the 'calc' token and the '=' token
            num_terms = len(tokens) - 2
            while count <= num_terms:
                token = tokens[count]
                if token == '+':
                    add_or_subtract = 1

                elif token == '-':
                    add_or_subtract = -1

                else:
                    # if the token has not been seen before,
                    # the result of the expression is unknown
                    # and we break
                    if token not in vars_dict:
                        print_answer(tokens, "unknown")
                        is_valid = False
                        break

                    result += add_or_subtract*vars_dict[token]

                count += 1

            # at the end of the 'calc' expression,
            # we check if the result itself is valid or not
            if is_valid:
                check_result_exists(result, vars_dict, tokens)

        else:
            vars_dict = {}


def print_answer(tokens, answer):
    """
    utility method to make
    printing easier

    :param tokens: list of tokens
    :param answer: a string

    """
    print(' '.join(tokens[1:]), answer)


def check_result_exists(result, vars_dict, tokens):
    """
    checks if the final result obtained
    from the 'calc' expression exists
    in the dictionary of variables or not

    :param result: int
    :param vars_dict: dict with (key, value) = (var_name, var_value)
    :param tokens: list of tokens

    """
    for var_name, val in vars_dict.items():
        if val == result:
            print_answer(tokens, var_name)
            return

    print_answer(tokens, "unknown")


main()
