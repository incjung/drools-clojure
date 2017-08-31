(ns drools.rules.Main)

(def status (atom {}))

(defn init []
  "init"
  (let [kieservice (org.kie.api.KieServices$Factory/get)
        kiecontainer  (.. kieservice getKieClasspathContainer)
        ksesson (.. kiecontainer newKieSession)]
    (swap! status assoc :kieservice kieservice)
    (swap! status assoc :kiecontainer kiecontainer)
    (swap! status assoc :ksesson ksesson)))


;;(def ks (org.kie.api.KieServices$Factory/get))
;;(def container (.. ks getKieClasspathContainer))
;;(def ksesson (.. container newKieSession))

(defn testFireRule []
  "Test Fire Rules"
  (let [shouldBeTooHot (drools.model.Temperature. 100)
        shouldBeTooCold (drools.model.Temperature. 20)]
    (.insert (:ksesson @status) shouldBeTooCold)
    (.insert (:ksesson @status) shouldBeTooHot)
    (.fireAllRules (:ksesson @status))))


(defn testFireRule1 []
  "Test Fire Rules"
  (let [shouldBeTooHot (drools.model.Temperature. 100)
        shouldBeTooCold (drools.model.Temperature. 199)]
    (.insert (:ksesson @status) shouldBeTooCold)
    (.insert (:ksesson @status) shouldBeTooHot)
    (.fireAllRules (:ksesson @status))))

(defn testFireRule2 []
  "Test Fire Rules"
  (let [shouldBeTooHot (drools.model.Temperature. 1)
        shouldBeTooCold (drools.model.Temperature. 2)]
    (.insert (:ksesson @status) shouldBeTooCold)
    (.insert (:ksesson @status) shouldBeTooHot)
    (.fireAllRules (:ksesson @status))))

(defn main []
  (init)
  (testFireRule))
