# 🏥 PlanifyLab-master

**PlanifyLab** est un mini moteur de planification pour un laboratoire médical.  
Il prend en entrée des échantillons, des techniciens et des équipements, puis génère un planning optimisé avec métriques.

---

## 🚀 Fonctionnalités

✅ Respect strict des priorités : **STAT > URGENT > ROUTINE**  
✅ Vérifie la compatibilité (technicien ↔ type d’échantillon, équipement ↔ type d’échantillon)  
✅ Évite les conflits de ressources (pas de double booking)  
✅ Génère un planning chronologique clair  
✅ Produit des métriques (temps total, efficacité, conflits)

---

## Structure

```text
📦 PlanifyLab-master
├─ 📄 pom.xml
└─ 📂 src
└─ 📂 main
├─ 📂 java
│  └─ 📂 com
│     └─ 📂 planifylab
│        ├─ 📄 Main.java
│        ├─ 📄 LabScheduler.java
│        ├─ 📄 Sample.java
│        ├─ 📄 Technician.java
│        ├─ 📄 Equipment.java
│        ├─ 📄 ScheduleEntry.java
│        └─ 📄 Metrics.java
└─ 📂 resources
└─ 📄 data.json
```

---
## 📦 Installation

### 1. Cloner le projet

```bash
git clone https://github.com/guigol/PlanifyLab-master.git
cd PlanifyLab-master

Sous Eclipse (JDK17), exécuter la commande suivante : 
mvn exec:java -Dexec.mainClass="com.planifylab.Main" 

Sous Intellij (JDK17), cliquer sur :
Start
```

