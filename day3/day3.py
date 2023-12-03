def read_prompt():
    file = open("C:/Users/rlham/aoc/2023/day3/input.txt", "r")
    prompt = [line[:-1] for line in file]
    file.close()
    return prompt

def parse_prompt(prompt):
    numbers = {}
    symbols = {}
    for i in range(len(prompt)):
        line = prompt[i]

        # entry(index: number)
        nums = {}
        syms = []
        number = ''
        for j in range(len(line)):
            char = line[j]
            if char.isdigit(): number += char
            # if number isn't length 0
            else:
                if len(number):
                    nums[j - len(number)] = number
                    number = ''
                if char != '.': syms.append(j)

        # handle hanging number
        if len(number):
            nums[len(line) - len(number)] = number
            number = ''

        # if not empty
        if nums: numbers[i] = nums
        if syms: symbols[i] = syms

    return numbers, symbols

if __name__ == '__main__':
    prompt = read_prompt()
    numbers, symbols = parse_prompt(prompt)

    for line, nums in numbers.items():
        for index, number in nums.items():
            print(f'on line {line} at index {index} lives number {number}')

    print()

    for line, indices in symbols.items():
        for i in indices:
            print(f'on line {line} at index {i} lives a symbol')