import matplotlib.pyplot as plt

def read_data(filename):
    x_values = []
    num_points_values = []
    error_csi_values = []
    error_simpson_values = []
    error_trapezoidal_values = []

    with open(filename, 'r') as file:
        for line in file:
            values = line.strip().split()
            x_values.append(float(values[0]))
            num_points_values.append(int(values[1]))
            error_csi_values.append(float(values[2]))
            error_simpson_values.append(float(values[3]))
            error_trapezoidal_values.append(float(values[4]))

    return x_values, num_points_values, error_csi_values, error_simpson_values, error_trapezoidal_values

x_values_sin3x, num_points_values_sin3x, error_csi_values_sin3x, error_simpson_values_sin3x, error_trapezoidal_values_sin3x = read_data('Sin3x.txt')
x_values_cosdiv5, num_points_values_cosdiv5, error_csi_values_cosdiv5, error_simpson_values_cosdiv5, error_trapezoidal_values_cosdiv5 = read_data('CosDiv5.txt')
x_values_ex, num_points_values_ex, error_csi_values_ex, error_simpson_values_ex, error_trapezoidal_values_ex = read_data('Ex.txt')

plt.figure(figsize=(12, 6))

plt.subplot(1, 3, 1)
plt.plot(num_points_values_sin3x, error_csi_values_sin3x, label='CSI')
plt.plot(num_points_values_sin3x, error_simpson_values_sin3x, label='Simpson')
plt.plot(num_points_values_sin3x, error_trapezoidal_values_sin3x, label='Trapezoidal')
plt.xlabel('Liczba punktów węzłowych')
plt.ylabel('Błąd')
plt.title('Sin(3x)')
plt.legend()

plt.subplot(1, 3, 2)
plt.plot(num_points_values_cosdiv5, error_csi_values_cosdiv5, label='CSI')
plt.plot(num_points_values_cosdiv5, error_simpson_values_cosdiv5, label='Simpson')
plt.plot(num_points_values_cosdiv5, error_trapezoidal_values_cosdiv5, label='Trapezoidal')
plt.xlabel('Liczba punktów węzłowych')
plt.ylabel('Błąd')
plt.title('Cos(x)/5')
plt.legend()

plt.subplot(1, 3, 3)
plt.plot(num_points_values_ex, error_csi_values_ex, label='CSI')
plt.plot(num_points_values_ex, error_simpson_values_ex, label='Simpson')
plt.plot(num_points_values_ex, error_trapezoidal_values_ex, label='Trapezoidal')
plt.xlabel('Liczba punktów węzłowych')
plt.ylabel('Błąd')
plt.title('e^x')
plt.legend()

plt.tight_layout()
plt.show()
