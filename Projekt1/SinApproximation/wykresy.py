import csv
import math
import matplotlib.pyplot as plt

x_vals = []
math_sin_vals = []
taylor1_vals = []
taylor2_vals = []
taylor3_vals = []
taylor4_vals = []

with open('results.csv', newline='') as csvfile:
    reader = csv.reader(csvfile)
    next(reader)
    for row in reader:
        x, math_sin, taylor1, taylor2, taylor3, taylor4 = map(float, row)
        x_vals.append(x)
        math_sin_vals.append(math_sin)
        taylor1_vals.append(abs(math_sin - taylor1))
        taylor2_vals.append(abs(math_sin - taylor2))
        taylor3_vals.append(abs(math_sin - taylor3))
        taylor4_vals.append(abs(math_sin - taylor4))

plt.plot(x_vals, taylor1_vals, label='Sumowanie od początku')
plt.plot(x_vals, taylor2_vals, label='Sumowanie od końca')
plt.plot(x_vals, taylor3_vals, label='Obliczanie kolejnego wyrazu na podstawie poprzedniego')
plt.plot(x_vals, taylor4_vals, label='Obliczanie kolejnego wyrazu na podstawie poprzedniego, sumowanie od końca')
plt.xlabel('x')
plt.ylabel('Błąd bezwzględny')
plt.title('Dokładność szeregu Taylora w porównaniu z funkcją biblioteczną Math.sin')
plt.legend()
plt.show()