import numpy as np
import matplotlib.pyplot as plt

trapezoidal_data = [
    (100, 0.23852036096448687),
    (200, 0.22212115110926264),
    (300, 0.19601212664333947),
    (400, 0.16850844085703226),
    (500, 0.1406159816880379),
    (600, 0.11257638212320553),
    (700, 0.08447010086008616),
    (800, 0.056329765094303486),
    (900, 0.02817049286435569),
    (1000, 7.771561172376096E-16)
]

simpson_data = [
    (100, 0.2742497120195412),
    (200, 0.2393040764242639),
    (300, 0.20730975976849894),
    (400, 0.17692203464781575),
    (500, 0.1473181389669816),
    (600, 0.11814553295004249),
    (700, 0.08923386589587434),
    (800, 0.060491629293949745),
    (900, 0.031865480446838845),
    (1000, 0.0033222859476388367)
]

csi_data = [
    (100, 0.317662344102558),
    (200, 0.30919703923956043),
    (300, 0.324263379117672),
    (400, 0.3457247443223523),
    (500, 0.36982473023849294),
    (600, 0.3952663334812694),
    (700, 0.42148275755032644),
    (800, 0.4481870218946503),
    (900, 0.47521827896676516),
    (1000, 0.5024793843129194)
]

x = np.arange(len(trapezoidal_data))
width = 0.25
fig, ax = plt.subplots()
rects1 = ax.bar(x - width, [item[1] for item in trapezoidal_data], width, label='Trapezoidal')
rects2 = ax.bar(x, [item[1] for item in simpson_data], width, label='Simpson')
rects3 = ax.bar(x + width, [item[1] for item in csi_data], width, label='CSI')

ax.set_xlabel('Number of Intervals')
ax.set_ylabel('Difference')
ax.set_title('Comparison of Integration Methods for sin(3x)')
ax.set_xticks(x)
ax.set_xticklabels([item[0] for item in trapezoidal_data])
ax.legend()

fig.tight_layout()

plt.show()
