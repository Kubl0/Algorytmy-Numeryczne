import matplotlib.pyplot as plt

def read_from_file(filename):
    x = []
    y = []
    with open(filename, 'r') as file:
        for line in file:
            data = line.split()
            x.append(float(data[0]))
            y.append(float(data[1]))
    return x, y

def divide_into_intervals(x, y, num_intervals):
    interval_size = len(x) // num_intervals
    x_intervals = [x[i:i+interval_size] for i in range(0, len(x), interval_size)]
    y_intervals = [y[i:i+interval_size] for i in range(0, len(y), interval_size)]
    return x_intervals, y_intervals

library_files = ['Library1.txt', 'Library2.txt', 'Library3.txt']
csi_files = ['CSI1.txt', 'CSI2.txt', 'CSI3.txt']
simpson_files = ['Simpson1.txt', 'Simpson2.txt', 'Simpson3.txt']
trapezoidal_files = ['Trapezoidal1.txt', 'Trapezoidal2.txt', 'Trapezoidal3.txt']

for i in range(3):
    x_library, y_library = read_from_file(library_files[i])
    x_csi, y_csi = read_from_file(csi_files[i])
    x_simpson, y_simpson = read_from_file(simpson_files[i])
    x_trapezoidal, y_trapezoidal = read_from_file(trapezoidal_files[i])
    x_library_intervals, y_library_intervals = divide_into_intervals(x_library, y_library, 10)
    x_csi_intervals, y_csi_intervals = divide_into_intervals(x_csi, y_csi, 10)
    x_simpson_intervals, y_simpson_intervals = divide_into_intervals(x_simpson, y_simpson, 10)
    x_trapezoidal_intervals, y_trapezoidal_intervals = divide_into_intervals(x_trapezoidal, y_trapezoidal, 10)
    csi = []
    simpson = []
    trapezoidal = []
    for j in range(10):
        csi.append(abs(y_csi_intervals[j][0] - y_library_intervals[j][0]))
        simpson.append(abs(y_simpson_intervals[j][0] - y_library_intervals[j][0]))
        trapezoidal.append(abs(y_trapezoidal_intervals[j][0] - y_library_intervals[j][0]))

    x_intervals = range(1, 11)
    plt.figure()
    plt.bar(x_intervals, csi, label='CSI')
    plt.bar(x_intervals, simpson, label='Simpson')
    plt.bar(x_intervals, trapezoidal, label='Trapezoidal')
    plt.xlabel('Interval')
    plt.ylabel('Difference')
    plt.title('Function ' + str(i+1))
    plt.legend()
    plt.savefig('function' + str(i+1) + '_plot.png')
    plt.show()
