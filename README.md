# spark-examples

This project is a mirror of the spark examples (`data` and `examples/src`) from the official spark distribution:
https://github.com/apache/spark/tree/v1.6.1

The build.sbt is based on the original pom.xml with some fixes.

## Build and run an example from the shell

```
$ sbt -Dspark.master=local[2] "runMain org.apache.spark.examples.SparkPi 1000"

...
[info] Running org.apache.spark.examples.SparkPi 1000
16/07/18 13:13:53 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Pi is roughly 3.1418342
[success] Total time: 32 s, completed Jul 18, 2016 1:14:20 PM
```


## Build and run from IntelliJ

IntelliJ -> Import project -> [find spark-examples/build.sbt]

All the errors should go away once IntelliJ automatically downloads all the dependencies (this takes a while).

Menu -> Run -> Edit Configurations -> + -> Application
```
Name: SparkPi
Main class: org.apache.spark.examples.SparkPi
VM Options: -Dspark.master=local[2]
Program parameters: 1000
```

Menu -> Run -> Run SparkPi


## Assembly jar and run with spark-submit

```
# build target/scala-2.10/spark-examples-assembly-1.6.1.jar
$ sbt assembly

# launch the example using spark-submit
$ $SPARK_HOME/bin/spark-submit --class org.apache.spark.examples.SparkPi --master local[2] target/scala-2.10/spark-examples-assembly-1.6.1.jar 1000

16/07/18 12:55:30 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Pi is roughly 3.14160476
```


## Select the example to run from sbt

```
$ sbt -Dspark.master=local[2] run
[info] Loading global plugins from /Users/david/.sbt/0.13/plugins
[info] Loading project definition from /Users/david/temp/spark-examples/project
[info] Set current project to spark-examples (in build file:/Users/david/temp/spark-examples/)
[warn] Multiple main classes detected.  Run 'show discoveredMainClasses' to see the list

Multiple main classes detected, select one to run:

 [1] org.apache.spark.examples.DriverSubmissionTest
 [2] org.apache.spark.examples.streaming.SqlNetworkWordCount
 [3] org.apache.spark.examples.streaming.QueueStream
 [4] org.apache.spark.examples.mllib.GradientBoostingRegressionExample
 [5] org.apache.spark.examples.streaming.DirectKafkaWordCount
 [6] org.apache.spark.examples.mllib.NaiveBayesExample
 [7] org.apache.spark.examples.mllib.MulticlassMetricsExample
 [8] org.apache.spark.examples.ml.SQLTransformerExample
 [9] org.apache.spark.examples.SimpleSkewedGroupByTest
 [10] org.apache.spark.examples.mllib.RegressionMetricsExample
 [11] org.apache.spark.examples.mllib.SampledRDDs
 [12] org.apache.spark.examples.LogQuery
 [13] org.apache.spark.examples.mllib.DecisionTreeRunner
 [14] org.apache.spark.examples.CassandraCQLTest
 [15] org.apache.spark.examples.ml.RandomForestClassifierExample
 [16] org.apache.spark.examples.mllib.DenseGaussianMixture
 [17] org.apache.spark.examples.mllib.SimpleFPGrowth
 [18] org.apache.spark.examples.LocalKMeans
 [19] org.apache.spark.examples.graphx.LiveJournalPageRank
 [20] org.apache.spark.examples.ml.NormalizerExample
 [21] org.apache.spark.examples.ml.OneVsRestExample
 [22] org.apache.spark.examples.ml.DCTExample
 [23] org.apache.spark.examples.streaming.clickstream.PageViewStream
 [24] org.apache.spark.examples.LocalALS
 [25] org.apache.spark.examples.ml.StandardScalerExample
 [26] org.apache.spark.examples.ml.PCAExample
 [27] org.apache.spark.examples.streaming.SimpleZeroMQPublisher
 [28] org.apache.spark.examples.streaming.ZeroMQWordCount
 [29] org.apache.spark.examples.streaming.NetworkWordCount
 [30] org.apache.spark.examples.streaming.FlumeEventCount
 [31] org.apache.spark.examples.mllib.DenseKMeans
 [32] org.apache.spark.examples.mllib.LDAExample
 [33] org.apache.spark.examples.mllib.CosineSimilarity
 [34] org.apache.spark.examples.streaming.FeederActor
 [35] org.apache.spark.examples.streaming.ActorWordCount
 [36] org.apache.spark.examples.streaming.StatefulNetworkWordCount
 [37] org.apache.spark.examples.mllib.StreamingLogisticRegression
 [38] org.apache.spark.examples.DFSReadWriteTest
 [39] org.apache.spark.examples.SparkALS
 [40] org.apache.spark.examples.ml.DecisionTreeRegressionExample
 [41] org.apache.spark.examples.ml.RFormulaExample
 [42] org.apache.spark.examples.ml.DecisionTreeClassificationExample
 [43] org.apache.spark.examples.mllib.MovieLensALS
 [44] org.apache.spark.examples.mllib.RandomRDDGeneration
 [45] org.apache.spark.examples.CassandraTest
 [46] org.apache.spark.examples.mllib.RandomForestClassificationExample
 [47] org.apache.spark.examples.ml.RandomForestExample
 [48] org.apache.spark.examples.GroupByTest
 [49] org.apache.spark.examples.streaming.FlumePollingEventCount
 [50] org.apache.spark.examples.mllib.RankingMetricsExample
 [51] org.apache.spark.examples.ml.IndexToStringExample
 [52] org.apache.spark.examples.ml.KMeansExample
 [53] org.apache.spark.examples.mllib.PrefixSpanExample
 [54] org.apache.spark.examples.mllib.GradientBoostedTreesRunner
 [55] org.apache.spark.examples.ml.StringIndexerExample
 [56] org.apache.spark.examples.ml.DataFrameExample
 [57] org.apache.spark.examples.mllib.MultiLabelMetricsExample
 [58] org.apache.spark.examples.ml.ElementwiseProductExample
 [59] org.apache.spark.examples.SkewedGroupByTest
 [60] org.apache.spark.examples.mllib.IsotonicRegressionExample
 [61] org.apache.spark.examples.ml.QuantileDiscretizerExample
 [62] org.apache.spark.examples.mllib.BinaryClassificationMetricsExample
 [63] org.apache.spark.examples.streaming.clickstream.PageViewGenerator
 [64] org.apache.spark.examples.streaming.TwitterAlgebirdHLL
 [65] org.apache.spark.examples.mllib.DecisionTreeClassificationExample
 [66] org.apache.spark.examples.ml.GradientBoostedTreeClassifierExample
 [67] org.apache.spark.examples.ml.ChiSqSelectorExample
 [68] org.apache.spark.examples.graphx.SynthBenchmark
 [69] org.apache.spark.examples.mllib.LBFGSExample
 [70] org.apache.spark.examples.mllib.TallSkinnySVD
 [71] org.apache.spark.examples.ml.AFTSurvivalRegressionExample
 [72] org.apache.spark.examples.ml.SimpleParamsExample
 [73] org.apache.spark.examples.LocalPi
 [74] org.apache.spark.examples.mllib.StreamingLinearRegression
 [75] org.apache.spark.examples.streaming.HdfsWordCount
 [76] org.apache.spark.examples.ml.GradientBoostedTreeRegressorExample
 [77] org.apache.spark.examples.mllib.SparseNaiveBayes
 [78] org.apache.spark.examples.SparkHdfsLR
 [79] org.apache.spark.examples.mllib.BinaryClassification
 [80] org.apache.spark.examples.mllib.AssociationRulesExample
 [81] org.apache.spark.examples.ml.VectorSlicerExample
 [82] org.apache.spark.examples.HdfsTest
 [83] org.apache.spark.examples.ml.BucketizerExample
 [84] org.apache.spark.examples.mllib.StreamingTestExample
 [85] org.apache.spark.examples.streaming.RecoverableNetworkWordCount
 [86] org.apache.spark.examples.streaming.TwitterAlgebirdCMS
 [87] org.apache.spark.examples.mllib.LinearRegression
 [88] org.apache.spark.examples.MultiBroadcastTest
 [89] org.apache.spark.examples.ml.CountVectorizerExample
 [90] org.apache.spark.examples.ml.LinearRegressionExample
 [91] org.apache.spark.examples.ml.SimpleTextClassificationPipeline
 [92] org.apache.spark.examples.streaming.TwitterPopularTags
 [93] org.apache.spark.examples.ml.NGramExample
 [94] org.apache.spark.examples.LocalLR
 [95] org.apache.spark.examples.HBaseTest
 [96] org.apache.spark.examples.SparkPi
 [97] org.apache.spark.examples.ml.StopWordsRemoverExample
 [98] org.apache.spark.examples.ml.RandomForestRegressorExample
 [99] org.apache.spark.examples.graphx.Analytics
 [100] org.apache.spark.examples.streaming.CustomReceiver
 [101] org.apache.spark.examples.SparkPageRank
 [102] org.apache.spark.examples.ml.BinarizerExample
 [103] org.apache.spark.examples.mllib.GradientBoostingClassificationExample
 [104] org.apache.spark.examples.mllib.Correlations
 [105] org.apache.spark.examples.mllib.DecisionTreeRegressionExample
 [106] org.apache.spark.examples.ml.LDAExample
 [107] org.apache.spark.examples.SparkLR
 [108] org.apache.spark.examples.ml.LogisticRegressionWithElasticNetExample
 [109] org.apache.spark.examples.SparkTC
 [110] org.apache.spark.examples.ml.TokenizerExample
 [111] org.apache.spark.examples.ml.LinearRegressionWithElasticNetExample
 [112] org.apache.spark.examples.mllib.RandomForestRegressionExample
 [113] org.apache.spark.examples.mllib.PowerIterationClusteringExample
 [114] org.apache.spark.examples.SparkKMeans
 [115] org.apache.spark.examples.mllib.StreamingKMeansExample
 [116] org.apache.spark.examples.SparkTachyonHdfsLR
 [117] org.apache.spark.examples.ml.TrainValidationSplitExample
 [118] org.apache.spark.examples.ml.GBTExample
 [119] org.apache.spark.examples.ml.OneHotEncoderExample
 [120] org.apache.spark.examples.ml.VectorIndexerExample
 [121] org.apache.spark.examples.SparkTachyonPi
 [122] org.apache.spark.examples.sql.RDDRelation
 [123] org.apache.spark.examples.mllib.BisectingKMeansExample
 [124] org.apache.spark.examples.sql.hive.HiveFromSpark
 [125] org.apache.spark.examples.streaming.MQTTPublisher
 [126] org.apache.spark.examples.streaming.MQTTWordCount
 [127] org.apache.spark.examples.mllib.MultivariateSummarizer
 [128] org.apache.spark.examples.ml.MovieLensALS
 [129] org.apache.spark.examples.ml.LogisticRegressionExample
 [130] org.apache.spark.examples.mllib.TallSkinnyPCA
 [131] org.apache.spark.examples.ml.DecisionTreeExample
 [132] org.apache.spark.examples.ml.PolynomialExpansionExample
 [133] org.apache.spark.examples.ml.LogisticRegressionSummaryExample
 [134] org.apache.spark.examples.ml.MultilayerPerceptronClassifierExample
 [135] org.apache.spark.examples.ml.CrossValidatorExample
 [136] org.apache.spark.examples.ml.MinMaxScalerExample
 [137] org.apache.spark.examples.streaming.KafkaWordCount
 [138] org.apache.spark.examples.streaming.KafkaWordCountProducer
 [139] org.apache.spark.examples.mllib.FPGrowthExample
 [140] org.apache.spark.examples.mllib.RecommendationExample
 [141] org.apache.spark.examples.ml.DeveloperApiExample
 [142] org.apache.spark.examples.BroadcastTest
 [143] org.apache.spark.examples.ml.Word2VecExample
 [144] org.apache.spark.examples.ml.TfIdfExample
 [145] org.apache.spark.examples.streaming.RawNetworkGrep
 [146] org.apache.spark.examples.LocalFileLR
 [147] org.apache.spark.examples.ExceptionHandlingTest
 [148] org.apache.spark.examples.ml.VectorAssemblerExample

Enter number: 96

[info] Running org.apache.spark.examples.SparkPi
16/07/18 13:15:36 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Pi is roughly 3.1412
[success] Total time: 38 s, completed Jul 18, 2016 1:15:45 PM
```
