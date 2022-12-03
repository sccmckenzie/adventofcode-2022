import string

# establish priorities
priorities = {}
i = 1
for letter in string.ascii_letters:
    priorities[letter] = i
    i = i + 1


# populate rucksacks from input file
rucksacks = {}
i = 0
with open('day3/input.txt') as file:    
    for line in file:
        items = list(line.replace('\n', ''))
        comp1 = items[0:int(len(items)/2)]
        comp2 = items[int(len(items)/2):len(items)]
        rucksacks[i] = {"comp1": comp1, "comp2": comp2}
        i = i + 1

# find duplicates
duplicates = []
for key in rucksacks:
    duplicates.append(set(rucksacks[key]['comp1']) & set(rucksacks[key]['comp2']))
    
# match duplicates w priority & sum
total = 0
for dupe in duplicates:
    total = total + priorities[dupe.pop()]

print(total)