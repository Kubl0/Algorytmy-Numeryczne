import random
import csv

def generate_numbers():
    with open('cyferki.csv', 'w', newline='') as csvfile:
        writer = csv.writer(csvfile, delimiter=';')
        for i in range(0, 1000):
            writer.writerow([random.randint(-2**16, 2**16-1)/2**16])

if __name__ == '__main__':
    generate_numbers()