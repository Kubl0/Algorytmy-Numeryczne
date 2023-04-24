import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("sin_function.csv", sep=';', header=None, names=[
    "x", "sin(x)", "tSin1", "tSin2", "tSin3", "tSin4"])

sin_x = df["sin(x)"]

# Wykres odleglosci funkcji tsin od sin(x)
for i in range(1, 5):
    blad = np.abs((df[f"tSin{i}"] - sin_x))
    print(f"Błąd dla tSin{i}: {blad.mean()}")
    plt.plot(df["x"], blad, label=f"tSin{i}")

plt.xlabel("x")
plt.ylabel("Odleglosc")
plt.legend()
# wykres liniowy
plt.yscale("linear")
plt.show()
