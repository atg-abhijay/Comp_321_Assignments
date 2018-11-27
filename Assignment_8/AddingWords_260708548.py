import sys

def main():
    vars_dict = {}
    for line in sys.stdin:
        tokens = line.split(' ')
        first_token = tokens[0]
        if first_token == 'def':
            vars_dict[tokens[1]] = int(tokens[2])

        elif first_token == 'calc':
            result, count = 0, 1
            num_terms = len(tokens) - 2
            while count <= num_terms:
                token = tokens[count]
                if token == '+':
                    return_values = evaluate_calc(tokens, vars_dict, count, 1)
                    result += return_values[1]
                    count += 2

                elif token == '-':
                    return_values = evaluate_calc(tokens, vars_dict, count, -1)
                    result -= return_values[1]
                    count += 2

                else:
                    return_values = evaluate_calc(tokens, vars_dict, count, 0)
                    result = return_values[1]
                    count += 1

                if not return_values[0]:
                    break

        else:
            vars_dict = {}


def evaluate_calc(tokens, vars_dict, count, operation):
    if tokens[count] not in vars_dict:
        print(' '.join(tokens[1:-1]), '= unknown')
        return False, -1

    if operation != 0:
        return True, vars_dict[tokens[count+1]]

    return True, vars_dict[tokens[count]]
