import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('resultValues.csv', delimiter=';')

plt.plot(df['Size'], df['DenseMatrixA2'], label='DenseMatrixA2')
plt.plot(df['Size'], df['BandMatrixA2'], label='BandMatrixA2')
plt.plot(df['Size'], df['SparseMatrixA2'], label='SparseMatrixA2')

plt.xlabel('Wielkość')
plt.ylabel('Błąd')
plt.title('Porównanie typów macierzy')

plt.legend()

plt.show()

data = pd.read_csv("resultValues2.csv", delimiter=';')
plt.plot(df['Size'], df['BandMatrixA2'], label='BandMatrixA2')
plt.xlabel('Wielkość')
plt.ylabel('Błąd')
plt.title('BandMatrixA2')

plt.legend()

plt.show()



