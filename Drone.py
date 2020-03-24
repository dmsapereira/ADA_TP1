def buildDrones(nRents):
    rentals = []

    for i in range(nRents):
        line = input()
        info = line.split(" ")
        rentals.append((int(info[0]), int(info[1]), int(info[2])))

    rentals.sort(key = lambda x : (x[0] + x[1]))
    return rentals

def compatible(a, b):
    return (rentals[a][0] + rentals[a][1] <= rentals[b][0]) or (rentals[a][0] >= rentals[b][0] + rentals[b][1])

def search(a):
    for x in range(a - 2, -1, -1):
        if compatible(x, a):
            return x 
    return -1


def solve(index):    
    gain = rentals[index][2]

    if compatible(index - 1, index):
        return gain + results[index]
    else:
        return max([gain + results[search(index) + 1], results[index]])

def fillList():
    results.append(0)
    results.append(rentals[0][2])

    for x in range(1 , len(rentals)):
        results.append(solve(x))

nIterations = int(input())

for i in range(nIterations):
    rentals = buildDrones(int(input()))
    results = []
    fillList()
    print(results[len(results) - 1])