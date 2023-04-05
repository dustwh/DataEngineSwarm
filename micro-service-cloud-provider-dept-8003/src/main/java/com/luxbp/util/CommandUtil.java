//package com.luxbp.util;
//
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
//import org.jline.reader.EndOfFileException;
//import org.jline.reader.LineReader;
//import org.jline.reader.LineReaderBuilder;
//import org.jline.reader.UserInterruptException;
//import org.jline.reader.impl.DefaultParser;
//import org.jline.terminal.Terminal;
//import org.jline.terminal.TerminalBuilder;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class CommandUtil implements CommandLineRunner {
//
//    //    private static Logger LOG = LoggerFactory.getLogger(CommandUtil.class);
//
//    @Override
//    public void run(String... args) throws Exception {
//        Terminal terminal = TerminalBuilder.builder().build();
//        DefaultParser parser = new DefaultParser();
//        LineReader reader = LineReaderBuilder.builder()
//                .terminal(terminal)
//                .parser(parser)
//                .build();
//        while (true) {
//            try {
//                String line = reader.readLine("prompt > ");
//                System.out.println(line);
//            } catch (UserInterruptException e) {
//                // Ignore
//            } catch (EndOfFileException e) {
//                return;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//}
