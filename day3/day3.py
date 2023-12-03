file = open("C:/Users/rlham/aoc/2023/day3/input.txt", "r")
prompt = [line[:-1] for line in file]
file.close()

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

    # if dictionary isn't empty
    if nums: numbers[i] = nums
    if syms: symbols[i] = syms

print(numbers)
print(symbols)

