import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df = pd.read_csv('results.csv', header=None, names=['x', 'sinMath', 'sinTaylor1', 'sinTaylor2', 'sinTaylor3', 'sinTaylor4'])

df['error1'] = abs(df['sinMath'] - df['sinTaylor1'])
df['error2'] = abs(df['sinMath'] - df['sinTaylor2'])
df['error3'] = abs(df['sinMath'] - df['sinTaylor3'])
df['error4'] = abs(df['sinMath'] - df['sinTaylor4'])

df['interval'] = pd.qcut(df['x'], q=6)
interval_means = df.groupby(['interval']).mean()

mean_error1 = interval_means['error1'].mean()
mean_error2 = interval_means['error2'].mean()
mean_error3 = interval_means['error3'].mean()
mean_error4 = interval_means['error4'].mean()

method_names = ['sinTaylor1', 'sinTaylor2', 'sinTaylor3', 'sinTaylor4']
interval_names = [f'Przedział {i+1}' for i in range(6)]
mean_errors = [interval_means[f'error{i}'] for i in range(1, 5)]

fig, ax = plt.subplots()
index = np.arange(len(interval_names))
bar_width = 0.2
opacity = 0.8

rects1 = ax.bar(index, mean_errors[0], bar_width,
                alpha=opacity,
                color='b',
                label=method_names[0])

rects2 = ax.bar(index + bar_width, mean_errors[1], bar_width,
                alpha=opacity,
                color='g',
                label=method_names[1])

rects3 = ax.bar(index + 2 * bar_width, mean_errors[2], bar_width,
                alpha=opacity,
                color='r',
                label=method_names[2])

rects4 = ax.bar(index + 3 * bar_width, mean_errors[3], bar_width,
                alpha=opacity,
                color='c',
                label=method_names[3])

ax.set_xlabel('Przedział')
ax.set_ylabel('Średni błąd')
ax.set_title('Średni błąd dla metod i przedziałów')
ax.set_xticks(index + 2 * bar_width / 2)
ax.set_xticklabels(interval_names)
ax.legend()

fig.tight_layout()
plt.show()
