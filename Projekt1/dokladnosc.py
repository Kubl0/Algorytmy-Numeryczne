import numpy as np
import pandas as pd
import matplotlib.pyplot as plt


def oblicz_dokladnosc(plik):

    df = pd.read_csv(plik, sep=';', header=None, names=[
                     "x", "sin(x)", "tSin1", "tSin2", "tSin3", "tSin4"])

    sin_x = df["sin(x)"]

    for i in range(1, 5):
        blad = np.abs((df[f"tSin{i}"] - sin_x))
        print(f"Błąd dla tSin{i}: {blad.mean()}")


oblicz_dokladnosc("sin_function.csv")

# wykres bledu z pliku n_values_acc.csv
data = pd.read_csv("n_values_acc.csv", header=None,
                   names=["n", "error"], sep=";")

plt.plot(data["n"], data["error"])
plt.xlabel("Ilość N")
plt.ylabel("error")
plt.yscale("log")
plt.show()


def oblicz_dokladnosc_przedzialami(plik):

    df = pd.read_csv(plik, sep=';', header=None, names=[
                     "x", "sin(x)", "tSin1", "tSin2", "tSin3", "tSin4"])

    sin_x = df["sin(x)"]

    parts = pd.cut(df["x"], 6, labels=False)

    for i in range(1, 5):
        blad = np.abs((df[f"tSin{i}"] - sin_x))
        avg_errors = []
        for j in range(6):
            part_blad = blad[parts == j]
            avg_error = part_blad.mean()
            part_range = f"{df['x'][parts == j].min():.2f}-{df['x'][parts == j].max():.2f}"
            avg_errors.append([avg_error, part_range])
        print(f"Błąd dla tSin{i}: {avg_errors}")


oblicz_dokladnosc_przedzialami("sin_function.csv")
