#Prueba de GitHub como herramienta colaborativa
class Persona:
    def __init__(self, edad, nombre):
        self.edad = edad
        self.nombre = nombre
    def getNombre(self):
        return self.nombre
    def getEdad(self):
        return self.edad
    def setNombre(self, n):
        self.nombre = n
    def setEdad(self, e):
        self.edad = e        

p1 = Persona(18, "lucas")
print(p1.getNombre(),"tiene",p1.getEdad(),"anhos")


    