# -*- coding: utf-8 -*-
"""
Created on Mon Apr  2 17:49:59 2018

@author: aparnami
"""
from sklearn.linear_model import LinearRegression, LogisticRegression
from sklearn.naive_bayes import GaussianNB
import json
import numpy as np

from flask import Flask, request, jsonify
app = Flask(__name__)

@app.route('/LinearRegression/Fit', methods=['POST'])
def LR_fit():
    X = request.form['X'] #json
    y = request.form['y'] # json
    X = json.loads(X) #python list
    y = json.loads(y) #python list
    reg = LinearRegression()
    reg.fit(X,y)
    return jsonify(
            coef = list(reg.coef_),
            inter = reg.intercept_)

@app.route('/LinearRegression/Predict', methods=['POST'])
def LR_predict():
    X = json.loads(request.form['X'])
    params = json.loads(request.form['params'])
    reg = LinearRegression()
    reg.coef_ = np.array(params['coef'])
    reg.intercept_ = params['inter']
    y = reg.predict(X)
    return jsonify (
            pred = list(y)
            )

@app.route('/LogisticRegression/Fit', methods=['POST'])
def LogR_fit():
    X = request.form['X'] #json
    y = request.form['y'] # json
    X = json.loads(X) #python list
    y = json.loads(y) #python list
    reg = LogisticRegression()
    reg.fit(X,y)
    coef = reg.coef_.tolist()
    inter = reg.intercept_.tolist()
    niter = reg.n_iter_.tolist()
    classes = reg.classes_.tolist()
    return jsonify(
            coef = coef,
            inter = inter,
            niter  = niter,
            classes = classes)

@app.route('/LogisticRegression/Predict', methods=['POST'])
def LogR_predict():
    X = json.loads(request.form['X'])
    params = json.loads(request.form['params'])
    reg = LogisticRegression()
    reg.coef_ = np.array(params['coef'])
    reg.intercept_ = np.array(params['inter'])
    reg.n_iter_ = np.array(params['niter'])
    reg.classes_ = np.array(params['classes'])
    y = reg.predict(X)
    return jsonify (
            pred = y.tolist()
            )

@app.route('/NaiveBayes/Fit', methods=['POST'])
def NB_fit():
    X = request.form['X'] #json
    y = request.form['y'] # json
    X = json.loads(X) #python list
    y = json.loads(y) #python list
    clf = GaussianNB()
    clf.fit(X,y)
    cp = clf.class_prior_.tolist()
    cc = clf.class_count_.tolist()
    t = clf.theta_.tolist()
    s = clf.sigma_.tolist()
    c = clf.classes_.tolist()
    return jsonify(
            class_prior = cp,
            class_count = cc,
            theta = t,
            sigma = s,
            classes = c)

@app.route('/NaiveBayes/Predict', methods=['POST'])
def NB_predict():
    X = json.loads(request.form['X'])
    params = json.loads(request.form['params'])
    clf = GaussianNB()
    clf.class_prior_ = np.array(params['class_prior'])
    clf.class_count_ = np.array(params['class_count'])
    clf.theta_ = np.array(params['theta'])
    clf.sigma_ = np.array(params['sigma'])
    clf.classes_ = np.array(params['classes'])
    y = clf.predict(X)
    return jsonify (
            pred = y.tolist()
            )

@app.route('/')
def Welcome():
   msg = """
   Welcome to ScalaML 1.0!
   * ScalaML is a Machine Learning Library built on the top of Python Scikit-Learn.
   * Use Scikit-Learn in Scala just as you do in Python.
   
   Available Classes:
   ----scalaml.LinearRegression-------(sklearn.linear_model.LinearRegression)
   ----scalaml.LogisticRegression-----(sklearn.linear_model.LogisticRegression)
   ----scalaml.NaiveBayes-------------(sklearn.naive_bayes.GaussianNB)
    
   Authors:
   Archit Parnami, Shipra Shinde, Pengyu Ni
   """
   msg = msg.replace('\n', '<br/>')

   return msg
