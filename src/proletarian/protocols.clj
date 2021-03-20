(ns proletarian.protocols)

(defprotocol QueueWorker
  "The process that runs the job workers for a particular queue."
  (start! [_]
    "Sets up a thread pool and starts polling for jobs.")
  (stop! [_]
    "Shuts down the job workers and the thread pool. Will allow running jobs
     to complete before shutting down the thread pool."))

(defprotocol Serializer
  "The Serializer encodes and decodes the job data payload as it is written to
   and read from the PostgreSQL tables."
  (encode [_ data]
    "Encode the data as a string before writing.")
  (decode [_ data-string]
    "Decode the data-as-string after reading."))
