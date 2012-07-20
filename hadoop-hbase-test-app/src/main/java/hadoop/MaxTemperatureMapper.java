package hadoop;// cc hadoop.MaxTemperatureMapper Mapper for maximum temperature example
// vv hadoop.MaxTemperatureMapper
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

import java.io.IOException;

public class MaxTemperatureMapper extends MapReduceBase

implements Mapper<LongWritable, Text, Text, IntWritable> {
  private static final int MISSING = 9999;
  
  public void map(LongWritable key, Text value,
      OutputCollector<Text, IntWritable> output, Reporter reporter)
      throws IOException {

      String line = value.toString();
      String year = line.substring(15, 19);
      int airTemperature;
      if (line.charAt(87) == '+') { // parseInt doesn't like leading plus signs
          airTemperature = Integer.parseInt(line.substring(88, 92));
      } else {
          airTemperature = Integer.parseInt(line.substring(87, 92));
      }
      String quality = line.substring(92, 93);
      if (airTemperature != MISSING && quality.matches("[01459]")) {
          output.collect(new Text(year), new IntWritable(airTemperature));
      }
  }
}
// ^^ hadoop.MaxTemperatureMapper
