def read_prompt():
    file = open("C:/Users/rlham/aoc/2023/day3/input.txt", "r")
    prompt = [line[:-1] for line in file]
    file.close()
    return prompt

def parse_prompt(prompt):
    numbers = {}
    for i in range(len(prompt)):
        line = prompt[i]

        # entry(index: number)
        nums = {}
        number = ''
        for j in range(len(line)):
            char = line[j]
            if char.isdigit(): number += char
            # if number isn't length 0
            elif len(number):
                nums[j - len(number)] = number
                number = ''

        # handle hanging number
        if len(number):
            nums[len(line) - len(number)] = number
            number = ''

        # if not empty
        if nums: numbers[i] = nums

    return numbers

if __name__ == '__main__':
    prompt = read_prompt()
    numbers = parse_prompt(prompt)
    sum = 0

    for line, nums in numbers.items():
        for index, number in nums.items():
            # print(f'on line {line} at index {index} lives number {number}')

            above = line - 1
            below = line + 1
            left = index - 1
            right = index + len(number)

            if right < len(prompt[line]):
                val = prompt[line][right]
                if val != '.' and not val.isdigit():
                    sum += int(number)
                    continue
            else: right -= 1
            
            if left >= 0:
                val = prompt[line][left]
                if val != '.' and not val.isdigit():
                    sum += int(number)
                    continue
            else: left += 1

            hit = False

            if above >= 0:
                for i in range(left, right + 1):
                    val = prompt[above][i]
                    if val != '.' and not val.isdigit():
                        hit = True
                        sum += int(number)
                        break
            if hit: continue

            if below < len(prompt):
                for i in range(left, right + 1):
                    val = prompt[below][i]
                    if val != '.' and not val.isdigit():
                        hit = True
                        sum += int(number)
                        break
            if hit: continue

    print(sum)


