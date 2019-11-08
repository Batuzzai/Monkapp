# -*- coding: utf-8 -*-
from kivy.app import App
from kivy.uix.button import Button
from kivy.uix.widget import Widget

class Pulsar(Widget):
    def presionar(self, tocar):
        print(tocar)
        
class Ventana(App):
    def build(self):
        return Button(text="Prueba")