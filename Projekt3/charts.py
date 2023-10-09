import matplotlib.pyplot as plt

# def plot_results(x, y1, y2, y3, y4, title):
def plot_results(x, y1, y2, y3, title):
    plt.figure(figsize=(10, 6))
    plt.plot(x, y1, label='CSI')
    plt.plot(x, y2, label='Simpson')
    plt.plot(x, y3, label='Trapezoidal')
    # plt.plot(x, y4, label='Library')
    plt.xlabel('x')
    plt.ylabel('Integral')
    plt.title(title)
    plt.legend()
    plt.grid(True)
    plt.show()

def read_from_file(filename):
    x = []
    y = []
    with open(filename, 'r') as file:
        for line in file:
            data = line.split()
            x.append(float(data[0]))
            y.append(float(data[1]))
    return x, y

x1, y1 = read_from_file('CSI1.txt')
x2, y2 = read_from_file('Simpson1.txt')
x3, y3 = read_from_file('Trapezoidal1.txt')
# x4, y4 = read_from_file('Library1.txt')
# plot_results(x1, y1, y2, y3, y4, 'Function 1')
plot_results(x1, y1, y2, y3, 'Function 1')

x1, y1 = read_from_file('CSI2.txt')
x2, y2 = read_from_file('Simpson2.txt')
x3, y3 = read_from_file('Trapezoidal2.txt')
# x4, y4 = read_from_file('Library2.txt')
# plot_results(x1, y1, y2, y3, y4, 'Function 2')
plot_results(x1, y1, y2, y3, 'Function 2')

x1, y1 = read_from_file('CSI3.txt')
x2, y2 = read_from_file('Simpson3.txt')
x3, y3 = read_from_file('Trapezoidal3.txt')
# x4, y4 = read_from_file('Library3.txt')
# plot_results(x1, y1, y2, y3, y4, 'Function 3')
plot_results(x1, y1, y2, y3, 'Function 3')
