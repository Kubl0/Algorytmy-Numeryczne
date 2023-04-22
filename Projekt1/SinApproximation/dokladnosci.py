import pandas as pd
import numpy as np
import math
import matplotlib.pyplot as plt

df = pd.read_csv('results.csv', header=None, names=['x', 'sinMath', 'sinTaylor1', 'sinTaylor2', 'sinTaylor3', 'sinTaylor4'])

df['error1'] = np.abs(df['sinMath'] - df['sinTaylor1'])
df['error2'] = np.abs(df['sinMath'] - df['sinTaylor2'])
df['error3'] = np.abs(df['sinMath'] - df['sinTaylor3'])
df['error4'] = np.abs(df['sinMath'] - df['sinTaylor4'])

mean_error1 = np.mean(df['error1'])
mean_error2 = np.mean(df['error2'])
mean_error3 = np.mean(df['error3'])
mean_error4 = np.mean(df['error4'])


print(f"Średnia dokładność metody 1: {mean_error1}")
print(f"Średnia dokładność metody 2: {mean_error2}")
print(f"Średnia dokładność metody 3: {mean_error3}")
print(f"Średnia dokładność metody 4: {mean_error4}")


interval_means = df.groupby(pd.IntervalIndex(pd.cut(df['x'], bins=10))).mean()

midpoints = [(interval.left + interval.right) / 2 for interval in interval_means.index]
plt.plot(midpoints, interval_means['error1'], label='Metoda 1')
plt.plot(midpoints, interval_means['error2'], label='Metoda 2')
plt.plot(midpoints, interval_means['error3'], label='Metoda 3')
plt.plot(midpoints, interval_means['error4'], label='Metoda 4')
plt.xlabel('Wartości argumentu x')
plt.ylabel('Średni błąd')
plt.legend()
plt.show()


values = [mean_error1, mean_error2, mean_error3, mean_error4]
labels = ['Metoda 1', 'Metoda 2', 'Metoda 3', 'Metoda 4']
plt.bar(labels, values)
plt.title('Porównanie błędów metod')
plt.xlabel('Metoda')
plt.ylabel('błąd')
plt.show()