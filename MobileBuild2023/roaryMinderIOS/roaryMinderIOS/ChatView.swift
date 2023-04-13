//
//  ChatView.swift
//  RoaryMinder
//
//  Created by Camila on 3/14/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ChatView: View {
    @State private var messageText = ""
    @State var messages: [String] = []
    var assignment: Assignments

    
    var body: some View {
        VStack{
            
            HStack{
//                Button(action:{
//                    print("Hello world")
//
//                },label:{
//                    Image(systemName: "chevron.backward")
//                        .foregroundColor(Color.blue)
//                        .padding(.horizontal, 0)
//                })
                
                Text(assignment.assignmentName)
                    .font(.subheadline)
                    .padding(.horizontal, 50)

                
            }
            
            //Messages
            ScrollView {
                
                
                ForEach(messages, id: \.self) { message in
                    // If the message contains [USER], that means it's us
                    if message.contains("[USER]") {
                        let newMessage = message.replacingOccurrences(of: "[USER]", with: "")
                        
                        // User message styles
                        HStack {
                            Spacer()
                            Text(newMessage)
                                .padding()
                                .foregroundColor(Color.white)
                                .background(Color.blue.opacity(0.8))
                                .cornerRadius(30)
                                .padding(.horizontal, 16)
                                .padding(.bottom, 10)
                        }
                    } else {
                        
                        // Other user message styles
                        HStack {
                            Text(message)
                                .padding()
                                .background(Color.gray.opacity(0.15))
                                .cornerRadius(30)
                                .padding(.horizontal, 16)
                                .padding(.bottom, 10)
                            Spacer()
                        }
                    }
                    
                }.rotationEffect(.degrees(180))
            }
            .rotationEffect(.degrees(180))
            .background(Color.gray.opacity(0.1))
            Spacer()
                .navigationBarTitle(assignment.assignmentName, displayMode: .inline)
            
            
            // Contains the Message bar
            HStack {
                TextField("Type something...", text: $messageText)
                    .padding()
                    .background(Color.gray.opacity(0.1))
                    .cornerRadius(40)
                    .onSubmit {
                        sendMessage(message: messageText)
                    }
                
                Button {
                    sendMessage(message: messageText)
                } label: {
                    Image(systemName: "paperplane.fill")
                }
                .font(.system(size: 26))
                .padding(.horizontal , 0)
            }
            .padding()
        }
    }
    
    func sendMessage(message: String) {
            messages.append("[USER]" + message)
            self.messageText = ""

            DispatchQueue.main.asyncAfter(deadline: .now() + 1) {
                withAnimation {
                    messages.append(getRoaryMinderResponse(message: message))
                }
            }
        }
    }


struct ChatView_Previews: PreviewProvider {
    static var previews: some View {
        let messages = ["Hello!", "How are you?"]
        let messagesArray = NSMutableArray(array: messages)
        let chatRepo = ChatRepos()
        let assignment = Assignments()


        ChatView(assignment: assignment)
    }
}

