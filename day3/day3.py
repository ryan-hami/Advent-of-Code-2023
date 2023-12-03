def read_prompt():
    file = open("C:/Users/rlham/aoc/2023/day3/input.txt", "r")
    prompt = [line[:-1] for line in file]
    file.close()
    return prompt

def parse_prompt():
    all_gears = {}
    numbers = {}
    for i in range(len(prompt)):
        line = prompt[i]

        # entry(index: number)
        nums = {}
        gears = []
        number = ''
        for j in range(len(line)):
            char = line[j]
            if char.isdigit(): number += char
            # if number isn't length 0
            else:
                if len(number):
                    nums[j - len(number)] = number
                    number = ''
                if char == '*':
                    gears.append(j)

        # handle hanging number
        if len(number):
            nums[len(line) - len(number)] = number
            number = ''

        # if not empty
        if nums: numbers[i] = nums
        if gears: all_gears[i] = gears

    return numbers, all_gears

def part_one():
    sum = 0

    for line, nums in numbers.items():
        for index, number in nums.items():
            #print(f'on line {line} at index {index} lives number {number}')

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


def part_two():
    sum = 0

    # map index to number
    linker = [[''] * len(line) for line in prompt]
    for line, nums in numbers.items():
        for index, number in nums.items():
            for i in range(len(number)):
                linker[line][index + i] = number

    for line, indices in gears.items():
        for i in indices:
            #print(f'on line {line} at index {i} lives a gear')

            neighbors = []

            above = line - 1
            below = line + 1
            left = i - 1
            right = i + 1

            if left >= 0:
                val = linker[line][left]
                if val.isdigit():
                    neighbors.append(val)
            else: left += 1

            if right < len(prompt[line]):
                val = linker[line][right]
                if val.isdigit():
                    neighbors.append(val)
            else: right -= 1

            if above >= 0:
                hit = False
                for i in range(left, right + 1):
                    val = linker[above][i]
                    if not hit and val.isdigit():
                        hit = True
                        neighbors.append(val)
                    elif hit and not val.isdigit():
                        hit = False

            if below < len(prompt):
                hit = False
                for i in range(left, right + 1):
                    val = linker[below][i]
                    if not hit and val.isdigit():
                        hit = True
                        neighbors.append(val)
                    elif hit and not val.isdigit():
                        hit = False

            if len(neighbors) != 2: continue
            
            gear_ratio = int(neighbors[0]) * int(neighbors[1])
            sum += gear_ratio

    print(sum)


if __name__ == '__main__':
    prompt = read_prompt()
    numbers, gears = parse_prompt()
    part_one()
    part_two()



