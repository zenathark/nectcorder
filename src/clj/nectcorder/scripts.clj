(ns nectcorder.scripts
  (:require [nectcorder.core :refer :all])
  (:import [org.bytedeco.javacpp ShortPointer Pointer BytePointer Loader]
           [org.bytedeco.libfreenect.global freenect]
           [org.bytedeco.libfreenect freenect_context freenect_usb_context]))



(def ctx (freenect_context.))
(def usb_ctx (freenect_usb_context.))
(freenect/freenect_init ctx usb_ctx)
(freenect/freenect_num_devices ctx)

(if -1 "hi" "no")

(def global_ctx (new-kinect-context))
global_ctx
(def w (create-main-window (first global_ctx)))

