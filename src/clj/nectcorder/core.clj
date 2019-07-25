(ns nectcorder.core
  (:require [fn-fx.fx-dom :as dom]
            [fn-fx.controls :as ui]
            [fn-fx.diff :refer [component defui render should-update?]])
  (:import [org.bytedeco.javacpp ShortPointer Pointer BytePointer Loader]
           [org.bytedeco.libfreenect.global freenect]
           [org.bytedeco.libfreenect freenect_context freenect_usb_context]))

(defn new-kinect-context
  []
  (let [ctx (freenect_context.)
        usb_ctx (freenect_usb_context.)]
    (freenect/freenect_init ctx usb_ctx)
    [ctx usb_ctx]))

(defn kinect-devices
  [^freenect_context ctx]
  (let [n-devices (freenect/freenect_num_devices ctx)]
    (when (pos? n-devices)
      (range n-devices))))

(defn create-main-window
  [ctx]
  (let [u (ui/stage
           :title "Hello, World!"
           :shown true
           :min-width 300
           :min-height 300
           :scene (ui/scene
                   :root (ui/stack-pane
                          :children [(ui/combo-box
                                      :id :device-selector
                                      :items (kinect-devices ctx)
                                      :on-action {:event :selection-changed
                                                  :fn-fx/include {:device-selector #{:value}}})])))
        handler-fn (fn [evt] (println "Recevied Event: " evt))]
    (dom/app u handler-fn)))

(defn- main
  [& args]
  (println "Hello, World!"))
