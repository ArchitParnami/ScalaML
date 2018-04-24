#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Apr 17 12:49:31 2018

@author: archit
"""

import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv('train.csv')
results = pd.read_csv('results.csv', header=None)

plt.scatter(df['X'], df['Y'], color='red')
plt.plot(results[0], results[1], color='green')
plt.xlabel('List Price')
plt.ylabel('Best Price')
plt.title('Price Regression')
plt.savefig('plot.png')

