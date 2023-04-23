import matplotlib.pyplot as plt
import numpy as np

methods = ['DenseMatrixA1', 'BandMatrixA1', 'SparseMatrixA1', 'DenseMatrixA2', 'BandMatrixA2', 'SparseMatrixA2']
times = [3.473042171641366E-12, 1.917789068352151E-15, 1.8861272319340628E-11, 4.2464911327369225E-14, 1.6117839800046077E-15, 1.4039918621756432E-14]

x_pos = np.arange(len(methods))

plt.bar(x_pos, times, align='center', alpha=0.5)
plt.xticks(x_pos, methods)
plt.ylabel('Błąd')
plt.yscale('log')
plt.title('Średni błąd algorytmów dla różnych typów macierzy')

plt.show()

data = {
    "DenseMatrixA1": 3.473042171641366E-12,
    "BandMatrixA1": 1.917789068352151E-15,
    "SparseMatrixA1": 1.8861272319340628E-11,
    "DenseMatrixA2": 4.2464911327369225E-14,
    "BandMatrixA2": 1.6117839800046077E-15,
    "SparseMatrixA2": 1.4039918621756432E-14
}


avg_a1 = (data["DenseMatrixA1"] + data["BandMatrixA1"] + data["SparseMatrixA1"]) / 3
avg_a2 = (data["DenseMatrixA2"] + data["BandMatrixA2"] + data["SparseMatrixA2"]) / 3

methods = ['A1', 'A2']
times = [avg_a1, avg_a2]

x_pos = np.arange(len(methods))

plt.bar(x_pos, times, align='center', alpha=0.5)
plt.xticks(x_pos, methods)
plt.ylabel('Błąd')
plt.yscale('log')
plt.title('Średni błąd algorytmów dla różnych typów macierzy')

plt.show()
